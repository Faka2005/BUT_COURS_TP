import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import HomeScreen from '../screen/HomeScreen';
import SecondScreen from "../screen/SecondScreen";



const Stack = createNativeStackNavigator();

const AppNavigation = () => {
    return (
        <NavigationContainer>
            <Stack.Navigator>
                <Stack.Screen name="Home"  options={{headerShown: false }} component={HomeScreen} />
                <Stack.Screen name="Second" options={{headerShown: false}} component={SecondScreen} />
            </Stack.Navigator>
        </NavigationContainer>
    );
}

export default AppNavigation;
