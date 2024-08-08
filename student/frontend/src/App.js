
// import './App.css';
import React, { useRef, useState, useEffect } from 'react';

import { InputText } from 'primereact/inputtext';
import { Card } from 'primereact/card';
import axios from "axios";
import { Button } from 'primereact/button';

function App() {

  const [nome, setNome] = useState();
  const [age, setAge] = useState();
  const [email, setEmail] = useState();
  const [list, setList] = useState([]);

  async function submeter() {

    const novoStudent =
    {
      "discente": nome,
      "age": age,
      "email": email,
    }


    axios.post("http://localhost:8080" + "/student", novoStudent)
      .then(Response => { })
      .catch(error => console.log(error))

  }

  async function acessar() {
    axios.get("http://localhost:8080/student")
      .then(response => {
        console.log("Dados recebidos:", response.data);
        setList(response.data);
      })
      .catch(error => console.log(error));
  }

  return (
    <div>

      <h1>STUDENT FRONT-END</h1>
      <Card title='STUDENT'>
        <InputText
          className={'p-mt-3'}
          value={nome}
          onChange={(e) => setNome(e.target.value)}
          style={{ width: '50%' }}
        />
      </Card>
      <Card title='AGE'>
        <InputText
          className={'p-mt-3'}
          value={age}
          onChange={(e) => setAge(e.target.value)}
          style={{ width: '50%' }}
        />
        <Card title='EMAIL'>
          <InputText
            className={'p-mt-3'}
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            style={{ width: '50%' }}
          />
        </Card>
      </Card>
      <Button className={'p-mt-3'} label="SALVAR" onClick={submeter} />
      <Button className={'p-mt-3'} label="ACESSAR" onClick={acessar} />
      <h2>Lista de Estudantes</h2>
      <ul>
        {list.map((student, index) => (
          <li key={index}>
            Nome: {student.nome}, Idade: {student.age}, Email: {student.email}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
