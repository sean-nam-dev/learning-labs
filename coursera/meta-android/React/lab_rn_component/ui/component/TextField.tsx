import {useState} from "react";
import {StyleSheet, TextInput} from "react-native";

export function TextField() {
    const [dish, onDishChange] = useState('')

    return (
        <TextInput
            style={ styles.textInput }
            value={ dish }
            onChangeText={ onDishChange }
            placeholder={ "Add a new dish" }
        />
    )
}

const styles = StyleSheet.create({
    textInput: {
        height: 40,
        margin: 12,
        borderWidth: 1,
        padding: 10,
        fontSize: 16,
        borderColor: '#3f544d',
        backgroundColor: '#EDEFEE',
    }
})