import {StyleSheet, View} from "react-native";
import LittleLemonAppBar from "./LittleLemonAppBar.tsx";
import WelcomeScreen from "./WelcomeScreen.tsx";

export default function LittleLemonScaffold() {
    return (
        <>
            <View style={styles.container}>
                <LittleLemonAppBar
                    text={ "Little Lemon" }
                    textSize={ 40 }
                />
                <WelcomeScreen />
            </View>
            <View style={styles.body}>
                <LittleLemonAppBar text={"All rights reserved by Little Lemon, 2022"} textSize={15} />
            </View>
        </>
    )
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#495E57',
    },
    body: {
        backgroundColor: '#495E57',
    },
})