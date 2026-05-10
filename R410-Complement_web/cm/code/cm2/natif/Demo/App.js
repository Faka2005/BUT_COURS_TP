import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View, Button, Alert } from 'react-native';

export default function App() {
  return (
    <View style={styles.container}>
      <Text>Helloo up App.js to start working on your app!</Text>
      <Button title="Hello" onPress={() => Alert.alert('Button with adjusted color pressed')}/>
      <StatusBar style="auto" />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
