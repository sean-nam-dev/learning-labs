import {StyleSheet, Text, View} from "react-native";

export function LittleLemonHeader() {
    return (
        <View style={ styles.container }>
            <Text style={ styles.text }>
                Little Lemon
            </Text>
        </View>
    )
}

const styles = StyleSheet.create({
    text: {
        fontSize: 30,
        paddingVertical: 25,
        fontWeight: 500
    },
    container: {
        backgroundColor: '#ec9973',
        alignItems: 'center'
    }
})