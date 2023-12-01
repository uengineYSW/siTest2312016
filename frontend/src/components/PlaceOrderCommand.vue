<template>
    <v-card outlined>
        <v-card-title>
            PlaceOrder
        </v-card-title>

        <v-card-text>
            <List&lt;MenuItem&gt; offline label="OrderItems" v-model="value.orderItems" :editMode="editMode" @change="change"/>
            <MenuItemList offline label="OrderItems" v-model="value.orderItems" :editMode="editMode" @change="change"/>
            <Address offline label="DeliveryAddress" v-model="value.deliveryAddress" :editMode="editMode" @change="change"/>
            <String label="ContactInfo" v-model="value.contactInfo" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="placeOrder"
            >
                PlaceOrder
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'PlaceOrderCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.orderItems = [];
            this.value.deliveryAddress = {};
            this.value.contactInfo = '';
        },
        watch: {
        },
        methods: {
            placeOrder() {
                this.$emit('placeOrder', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

