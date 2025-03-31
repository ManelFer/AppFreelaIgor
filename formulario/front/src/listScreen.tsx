import React, { useEffect, useState } from 'react';
import { View, Text, FlatList, StyleSheet, ActivityIndicator, TouchableOpacity, Alert } from 'react-native';
import { fetchAlunos } from './services/api';
import { useNavigation, NavigationProp } from '@react-navigation/native';

export default function ListScreen() {
  const [pais, setPais] = useState<any[]>([]);
  const [isLoading, setIsLoading] = useState(true);
  type RootStackParamList = {
    Form: { pais: any };
  };

  const navigation = useNavigation<NavigationProp<RootStackParamList>>();

  useEffect(() => {
    const loadAlunos = async () => {
      try {
        const data = await fetchAlunos();
        setPais(data);
      } catch (error) {
        console.error(error);
        Alert.alert('Erro', 'Não foi possível carregar os alunos');
      } finally {
        setIsLoading(false);
      }
    };
    
    loadAlunos();
  }, []);

  if (isLoading) {
    return (
      <View style={styles.center}>
        <ActivityIndicator size="large" />
      </View>
    );
  }

  return (
    <View style={styles.container}>
      <FlatList
        data={pais}
        keyExtractor={(item) => item.id.toString()}
        renderItem={({ item }) => (
          <TouchableOpacity 
            style={styles.item}
            onPress={() => navigation.navigate('Form', { pais: item })}
          >
            <Text style={styles.itemName}>{item.nome} {item.sobrenome}</Text>
            <Text style={styles.itemEmail}>{item.email}</Text>
          </TouchableOpacity>
        )}
        ListEmptyComponent={
          <Text style={styles.empty}>Nenhum aluno cadastrado</Text>
        }
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 10,
  },
  center: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  item: {
    padding: 15,
    marginBottom: 10,
    backgroundColor: '#fff',
    borderRadius: 5,
    elevation: 2,
  },
  itemName: {
    fontSize: 16,
    fontWeight: 'bold',
  },
  itemEmail: {
    color: '#666',
  },
  empty: {
    textAlign: 'center',
    marginTop: 20,
    color: '#999',
  },
});