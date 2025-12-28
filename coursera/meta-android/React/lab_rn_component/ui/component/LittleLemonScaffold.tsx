import {SectionList, StyleSheet, Text, View} from "react-native";
import * as React from "react";

const menuItemsToDisplay = [
    {
        title: 'Appetizers',
        data: [
            { name: 'Hummus', price: '$5.00' },
            { name: 'Moutabal', price: '$5.00' },
            { name: 'Falafel', price: '$7.50' },
            { name: 'Marinated Olives', price: '$5.00' },
            { name: 'Kofta', price: '$5.00' },
            { name: 'Eggplant Salad', price: '$8.50' },
        ],
    },
    {
        title: 'Main Dishes',
        data: [
            { name: 'Lentil Burger', price: '$10.00' },
            { name: 'Smoked Salmon', price: '$14.00' },
            { name: 'Kofta Burger', price: '$11.00' },
            { name: 'Turkish Kebab', price: '$15.50' },
        ],
    },
    {
        title: 'Sides',
        data: [
            { name: 'Fries', price: '$3.00', id: '11K' },
            { name: 'Buttered Rice', price: '$3.00' },
            { name: 'Bread Sticks', price: '$3.00' },
            { name: 'Pita Pocket', price: '$3.00' },
            { name: 'Lentil Soup', price: '$3.75' },
            { name: 'Greek Salad', price: '$6.00' },
            { name: 'Rice Pilaf', price: '$4.00' },
        ],
    },
    {
        title: 'Desserts',
        data: [
            { name: 'Baklava', price: '$3.00' },
            { name: 'Tartufo', price: '$3.00' },
            { name: 'Tiramisu', price: '$5.00' },
            { name: 'Panna Cotta', price: '$5.00' },
        ],
    },
];

type MenuItem = {
    name: string;
    price: string;
};

type MenuSection = {
    title: string;
    data: MenuItem[];
};

const Separator = () => <View style={ styles.separator } />

const Footer = () => <Text style={ styles.footer }>All rights reserved by Little Lemon, 2022</Text>

const Item = ({ name, price }: MenuItem) => {
    return (
        <View style={styles.itemRow}>
            <Text style={styles.itemText}>{name}</Text>
            <Text style={styles.itemText}>{price}</Text>
        </View>
    );
};

export function LittleLemonScaffold() {
    const renderItem = ({ item }: { item: MenuItem }) => (
        <Item name={item.name} price={item.price} />
    );
    const renderHeader = ({ section }: { section: MenuSection }) => (
        <Text style={styles.sectionHeader}>{section.title}</Text>
    );

    return (
        <SectionList
            style={ styles.container }
            sections={ menuItemsToDisplay }
            renderItem={ renderItem }
            renderSectionHeader={ renderHeader }
            ListFooterComponent={ Footer }
            ItemSeparatorComponent={ Separator }
        />
    )
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#3f544d'
    },
    itemRow: {
        flexDirection: 'row',
        justifyContent: 'space-between',
        paddingHorizontal: 20,
        paddingVertical: 10,
    },
    itemText: {
        color: '#F4CE14',
        fontSize: 25,
    },
    sectionHeader: {
        backgroundColor: '#fbdabb',
        color: 'white',
        fontSize: 35,
        flexWrap: 'wrap',
        textAlign: 'center',
    },
    footer: {
        paddingTop: 20,
        paddingBottom: 40,
        color: 'white',
        fontSize: 20,
        flexWrap: 'wrap',
        textAlign: 'center',
    },
    separator: {
        borderBottomWidth: 1,
        borderColor: '#EDEFEE'
    }
})