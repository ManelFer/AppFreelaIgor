import React, { useState } from 'react';
import { View, TextInput, Button, Alert, StyleSheet } from 'react-native';
import { saveFormData } from './services/api';

export default function FormScreen() {
  const [nome, setNome] = useState('');
  const [email, setEmail] = useState('');
  const [sobrenome, setSobrenome] = useState('');
  const [idade, setIdade] = useState('');
  const [endereco, setEndereco] = useState('');

  const handleSubmit = async () => {
    try {
      await saveFormData({ nome, sobrenome, email, idade, endereco });
      Alert.alert('Sucesso!', 'Dados enviados para o back-end.');
      setNome('');
      setSobrenome('');
      setEmail('');
      setIdade('');
      setEndereco('');
    } catch (error) {
      Alert.alert('Erro', 'Falha ao enviar dados.');
    }
  };

  return (
    <View style={styles.container}>
        <TextInput
            style={styles.input}
            placeholder="Nome"
            value={nome}
            onChangeText={setNome}
        />
        <TextInput
            style={styles.input}
            placeholder="Sobrenome"
            value={sobrenome}
            onChangeText={setSobrenome}
        />
        <TextInput
            style={styles.input}
            placeholder="E-mail"
            value={email}
            onChangeText={setEmail}
            keyboardType="email-address"
        />
        <TextInput
            style={styles.input}
            placeholder="Idade"
            value={idade}
            onChangeText={setIdade}
            keyboardType="numeric"
        />
        <TextInput
            style={styles.input}
            placeholder="Endereço"
            value={endereco}
            onChangeText={setEndereco}
            multiline={true}
        />
        <Button title="Cadastrar" onPress={handleSubmit} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: { padding: 20 },
  input: { 
    height: 40, 
    borderColor: 'gray', 
    borderWidth: 1, 
    marginBottom: 10, 
    padding: 10 
  }
});