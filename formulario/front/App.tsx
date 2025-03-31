import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import FormScreen from './src/formScreen';
import ListScreen from './src/listScreen';

type RootStackParamList = {
  Form: { pais?: any };
  List: undefined;
};

const Stack = createStackNavigator<RootStackParamList>();

export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName="Form">
        <Stack.Screen 
          name="Form" 
          component={FormScreen} 
          options={{ title: 'Cadastro de Pais ' }}
        />
        <Stack.Screen 
          name="List" 
          component={ListScreen} 
          options={{ title: 'Lista de Alunos' }}
        />
      </Stack.Navigator>
    </NavigationContainer>
  );
}