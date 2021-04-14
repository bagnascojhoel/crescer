import React, { useState } from 'react';
import { useHistory } from 'react-router-dom';
import { ROUTES } from '../../../routes';
import './style.css';
import { InputTextField, Form, ButtonContainer } from '../../components';
import { useLoginHelper } from '../../../hooks';

export function UserLoginScreen() {
  const history = useHistory();
  const loginHelper = useLoginHelper();
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleSubmit = async () => {
    try {
      const response = await loginHelper.login(username, password);
      history.push(ROUTES.CHARACTER);
    } catch (err) {
      alert(`Usuário ou senha incorretos: ${err}`);
    }
  };

  const handleChangeUsername = (value) => {
    setUsername(value);
  };

  const handleChangePassword = (value) => {
    setPassword(value);
  };

  return (
    <div className="container login-screen">
      <img src="logo.png" alt="Logo world of react" />

      <Form onSubmit={handleSubmit}>
        <InputTextField
          onChange={handleChangeUsername}
          label="Usuário"
          name="username"
          type="text"
          value={username}
        />
        <InputTextField
          onChange={handleChangePassword}
          label="Senha"
          type="password"
          name="password"
          value={password}
        />

        <ButtonContainer>Entrar</ButtonContainer>
      </Form>
    </div>
  );
}
