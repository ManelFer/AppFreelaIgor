import axios from 'axios';

const api = axios.create({
  baseURL: 'http://10.0.1.83:8081/api', // Substitua pelo IP do seu back-end Java
  timeout: 10000, // Tempo limite de 10 segundos
  headers: {
    'Content-Type': 'application/json',
  },
});



export const saveFormData = async (alunoData: {
  nome: string;
  sobrenome: string;
  email: string;
  idade: string;
  endereco: string;
}) => {
  try {
    // Convertendo idade para número
    const payload = {
      ...alunoData,
      idade: parseInt(alunoData.idade, 10),
    };
    
    const response = await api.post('/', payload);
    return response.data;
  } catch (error) {
    console.error('Erro ao salvar aluno:', error);
    throw error;
  }
};

export const fetchAlunos = async () => {
  try {
    const response = await api.get('/');
    return response.data;
  } catch (error) {
    console.error('Erro ao buscar alunos:', error);
    throw error;
  }
};

export default api;