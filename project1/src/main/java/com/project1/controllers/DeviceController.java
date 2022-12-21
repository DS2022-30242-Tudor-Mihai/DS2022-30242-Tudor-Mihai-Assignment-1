package com.project1.controllers;

import com.project1.dtos.builders.DeviceBuilder;
import com.project1.dtos.builders.UserBuilder;
import com.project1.dtos.validators.DeviceDTO;
import com.project1.entities.Users;
import com.project1.services.DeviceService;
import com.project1.services.UserService;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "device")
public class DeviceController {
    private final DeviceService deviceService;
    private final UserService userService;

    public DeviceController(DeviceService deviceService, UserService userService) {
        this.deviceService = deviceService;
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<DeviceDTO>> getDevices() {
        List<DeviceDTO> deviceDTOS = deviceService.getDevices();
        for(DeviceDTO dto : deviceDTOS){
            Link deviceLink = linkTo(methodOn(DeviceController.class)
                    .getDevices()).withRel("deviceDetails");
            dto.add(deviceLink);
        }
        return new ResponseEntity<>(deviceDTOS, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<DeviceDTO> insertDevice(@Valid @RequestBody DeviceDTO deviceDTO) {

        DeviceDTO deviceDTO1 = deviceService.insert(deviceDTO);
        return new ResponseEntity<>(deviceDTO1, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<DeviceDTO> editDevice(@Valid @RequestBody DeviceDTO deviceDTO) {
        DeviceDTO deviceDTO1 = deviceService.update(deviceDTO);
        return new ResponseEntity<>(deviceDTO1, HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> deleteDevice(@PathVariable("id") Integer id) {
        deviceService.delete(id);
        return new ResponseEntity<>("Worked", HttpStatus.ACCEPTED);
    }

//    @GetMapping(value = "/{username}")
//    public ResponseEntity<List<DeviceDTO>> getDevicesByUserId(@PathVariable("username") String username) {
//        Users user = UserBuilder.toEntityWithId(userService.findUserByUsername(username));
//        List<DeviceDTO> deviceDTOS = user.getDevices().stream().map(DeviceBuilder::toDeviceDTO).collect(Collectors.toList());
//        for(DeviceDTO dto : deviceDTOS){
//            Link deviceLink = linkTo(methodOn(DeviceController.class)
//                    .getDevices()).withRel("deviceDetails");
//            dto.add(deviceLink);
//        }
//        return new ResponseEntity<>(deviceDTOS, HttpStatus.OK);
//    }
}
