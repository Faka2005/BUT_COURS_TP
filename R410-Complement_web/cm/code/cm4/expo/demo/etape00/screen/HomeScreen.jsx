import { View, Text, StatusBar, Button,Alert} from "react-native";
import { useNavigation } from '@react-navigation/native'
import Search from "../components/Search";
const HomeScreen = () => {

    const navigation = useNavigation()

    return (
        <View>
            <Search/>

            <StatusBar style="auto" />

        </View>
    );
}

export default HomeScreen;
