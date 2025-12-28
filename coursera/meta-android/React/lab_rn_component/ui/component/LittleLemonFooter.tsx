import {StyleSheet, Text, View} from "react-native";

export function LittleLemonFooter() {
    return (
        <View style={ styles.container }>
            <Text style={ styles.text }>
                All rights reserved by Little Lemon, 2022
            </Text>
        </View>
    )
}

const styles = StyleSheet.create({
    text: {
        fontSize: 15,
        fontWeight: 500,
        fontStyle: "italic"
    },
    container: {
        backgroundColor: '#ec9973',
        alignItems: 'center',
        paddingBottom: 25,
        paddingTop: 5
    }
})