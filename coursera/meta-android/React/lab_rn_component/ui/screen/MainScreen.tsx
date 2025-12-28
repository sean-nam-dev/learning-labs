import LittleLemonAppBar from "../component/LittleLemonAppBar.tsx";
import {LittleLemonScaffold} from "../component/LittleLemonScaffold.tsx";
import {TextField} from "../component/TextField.tsx";
import {StyleSheet, View} from "react-native";

export function MainScreen() {
    return (
      <View style={ styles.container }>
          <LittleLemonAppBar
              text={ "Little Lemon" }
              textSize={ 40 }
          />
          <TextField />
          <LittleLemonScaffold />
      </View>
    )
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#3f544d'
    }
})