import {TextInput, SafeAreaView,StyleSheet} from 'react-native';
import { useNavigation } from '@react-navigation/native'

const styles = StyleSheet.create({
    input: {
        height: 40,
        margin: 12,
        borderWidth: 1,
        padding: 10,
    },
});

export default function Search(props){
    const navigation = useNavigation()
    return (
        <SafeAreaView>
        <TextInput placeholder={"Searched movie"} style={styles.input} readOnly={false} onSubmitEditing={(text)=>{navigation.push("Second",{message: 'TODO'})}}/>
        </SafeAreaView>
            )
}
