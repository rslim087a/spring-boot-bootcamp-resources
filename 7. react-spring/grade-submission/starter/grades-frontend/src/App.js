import React, { Component } from 'react';
import './grades.css';

class App extends Component {

	constructor(props) {
		super(props);
		this.state = {grades: []};
	}

  
  async componentDidMount() {
    fetch('http://localhost:8080/grades')
      .then(response => response.json())
      .then(data =>  {
        this.setState({grades : data});
    })
  }

  render() {
    return (

      <div>
        <div class= "container">
          <table id= "table">
            <tr>
              <th>Student</th>
              <th>Subject</th>
              <th>Score</th>
            </tr>
              {
                this.state.grades.map((grade, index) =>  
                       <tr key={index}>
                          <td>{grade.name}</td>
                          <td>{grade.subject}</td>
                          <td>{grade.score}</td>
                        </tr>
                  )
              }
        </table>        
        </div>

      </div>
    );
  }
}

export default App;