import { View, Text, StatusBar, Button,Alert} from "react-native";
import { useRoute, useNavigation } from '@react-navigation/native'
const SecondScreen = () => {

    const navigation = useNavigation()
    const { params: item } = useRoute()
    console.log(item)
    return (
        <View className="flex-1 bg-neutral-800">

                    <Text className="text-white text-3xl font-bold" >
                        Second {item.message}
                    </Text>
            <Button
                title="Press me"
                onPress={() => {
                    Alert.alert('Simple Button pressed')
                    navigation.goBack()
                }}
            />
            <StatusBar style="auto" />

        </View>
    );
}

export default SecondScreen;
