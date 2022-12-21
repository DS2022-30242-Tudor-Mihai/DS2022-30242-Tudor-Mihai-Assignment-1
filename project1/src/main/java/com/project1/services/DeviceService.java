package com.project1.services;

import com.project1.dtos.builders.DeviceBuilder;
import com.project1.dtos.validators.DeviceDTO;
import com.project1.entities.Device;
import com.project1.repositories.DeviceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeviceService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DeviceService.class);
    private final DeviceRepository deviceRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }
    @Transactional
    public List<DeviceDTO> getDevices() {
        List<Device> devicesList = deviceRepository.findAll();
        return devicesList.stream().map(DeviceBuilder::toDeviceDTO).collect(Collectors.toList());
    }
    @Transactional
    public DeviceDTO insert(DeviceDTO deviceDTO){
        Device device = DeviceBuilder.toEntity(deviceDTO);
        device = deviceRepository.save(device);
        LOGGER.debug("Device with id {} was inserted in db", device.getId());
        return DeviceBuilder.toDeviceDTO(device);
    }
    @Transactional
    public DeviceDTO update(DeviceDTO deviceDTO) {
        Device device = DeviceBuilder.toEntity(deviceDTO);
        deviceRepository.save(device);
        return (deviceDTO);
    }
    @Transactional
    public void delete(Integer id){
        Optional<Device> device = deviceRepository.findById(id);
        if(device.isPresent()) {
            LOGGER.debug("Device with id {} is deleted from db", device.get().getId());
            deviceRepository.delete(device.get());
        }
    }
}
