import { getDefaultNormalizer } from "@testing-library/react";
import React, { Component } from "react";
import {Button, Form} from "react-bootstrap";
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend
} from "chart.js";
import { Bar } from "react-chartjs-2";
import DeviceService from "../../Services/DeviceService";

ChartJS.register(
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend
);

export default class ReadingsComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      devices: [],
      device: '',
      date: '',
      readings: []
    };
  }

  labels = [
    0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
    21, 22, 23
  ];

  onChange = (event) => {
    this.setState({
      [event.target.name]: event.target.value
    });
  };

  componentDidMount(){
    DeviceService.getDevicesByUserUsername(localStorage.getItem("username")).then((response) => {
        this.setState({ devices : response.data , device : response.data[0].id})
    });
    }

  getData = event => {
    event.preventDefault();
    DeviceService.findReadingsByDeviceIdDate(this.state.device, this.state.date)
        .then((response) => {
            if(response.data != null){
                const dataToShow = [];
                //console.log(this.state.readings);
                response.data.forEach((data) => dataToShow.push(data.consumption));
                this.setState({ readings: dataToShow });
            }
        });
  };

  render() {
    return (
      <div style={{ display: "flex" }}>
        <div
          style={{
            display: "flex",
            justifyContent: "center",
            height: "500px",
            width: "100%"
          }}
          className="bg-dark"
        >
          <form
            style={{
              display: "flex",
              flexDirection: "column",
              alignItems: "center",
              justifyContent: "center"
            }}
          >
            <div className="text-white">
              Device Id:
              <Form.Control required autoComplete="off" 
               as="select" name="device" 
               value={this.state.device} onChange={this.onChange} 
               className={"bg-dark text-white"}>
               {this.state.devices.map(device => 
               (
                   <option value={device.id}>
                       {device.id}
                   </option>
               ))}
              </Form.Control> 
            </div>
            <div className="m-2 text-white">
              Date:
              <input
                type="date"
                className="m-2 bg-dark text-white"
                name="date"
                value={this.date}
                onChange={this.onChange}
              />
            </div>
            <Button size="sm" variant="success" type="submit" onClick={this.getData}>
             Get
            </Button>
          </form>
          <div
            style={{
              display: "flex",
              justifyContent: "center",
              alignItems: "center"
            }}
          >
            <Bar
              options={{
                plugins: {
                  title: {
                    display: true,
                    text: "Here is your device consumption for the respective day"
                  }
                },
                responsive: true,
                interaction: {
                  mode: "index",
                  intersect: false
                },
                scales: {
                  x: {
                    stacked: true
                  },
                  y: {
                    stacked: true
                  }
                }
              }}
              data={{
                labels: this.labels,
                datasets: [
                  {
                    label: "Readings",
                    data: this.state.readings,
                    backgroundColor: "rgb(255, 99, 132)",
                    stack: "Stack 0"
                  }
                ]
              }}
              style={{ height: "400px", margin: "50px" }}
            />
          </div>
        </div>
      </div>
    );
  }
}