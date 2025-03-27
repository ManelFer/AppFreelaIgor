import axios from 'axios';

const api = axios.create({
  baseURL: 'http://SEU_IP_LOCAL:8080/api', // Substitua pelo IP do seu back-end Java
});

interface FormData {
  nome: string;
  email: string;
}

export const saveFormData = (data: FormData) => api.post('/salvar-formulario', null, { 
  params: data 
});