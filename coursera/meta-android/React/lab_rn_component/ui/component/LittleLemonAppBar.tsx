import {StyleSheet, Text, View} from "react-native";

type Props = {
    text: string;
    textSize: number;
}

export default function LittleLemonAppBar({ text, textSize }: Props) {
    return (
        <View style={styles.view}>
        <Text style={[styles.text, { fontSize: textSize }]}>
            { text }
        </Text>
    </View>
    )
}

const styles = StyleSheet.create({
    view: {
        backgroundColor: '#F4CE14',
        alignItems: 'center'
    },
    text: {
        padding: 40,
        color: 'black',
        fontWeight: '500'
    }
})