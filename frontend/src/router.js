
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import DeliveryOrderOrderManager from "./components/listers/DeliveryOrderOrderCards"
import DeliveryOrderOrderDetail from "./components/listers/DeliveryOrderOrderDetail"
import DeliveryOrderMenuItemManager from "./components/listers/DeliveryOrderMenuItemCards"
import DeliveryOrderMenuItemDetail from "./components/listers/DeliveryOrderMenuItemDetail"

import DeliveryFulfillmentFulfillmentManager from "./components/listers/DeliveryFulfillmentFulfillmentCards"
import DeliveryFulfillmentFulfillmentDetail from "./components/listers/DeliveryFulfillmentFulfillmentDetail"

import OrderStatusOrderStatusManager from "./components/listers/OrderStatusOrderStatusCards"
import OrderStatusOrderStatusDetail from "./components/listers/OrderStatusOrderStatusDetail"

import PaymentProcessingPaymentManager from "./components/listers/PaymentProcessingPaymentCards"
import PaymentProcessingPaymentDetail from "./components/listers/PaymentProcessingPaymentDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/deliveryOrders/orders',
                name: 'DeliveryOrderOrderManager',
                component: DeliveryOrderOrderManager
            },
            {
                path: '/deliveryOrders/orders/:id',
                name: 'DeliveryOrderOrderDetail',
                component: DeliveryOrderOrderDetail
            },
            {
                path: '/deliveryOrders/menuItems',
                name: 'DeliveryOrderMenuItemManager',
                component: DeliveryOrderMenuItemManager
            },
            {
                path: '/deliveryOrders/menuItems/:id',
                name: 'DeliveryOrderMenuItemDetail',
                component: DeliveryOrderMenuItemDetail
            },

            {
                path: '/deliveryFulfillments/fulfillments',
                name: 'DeliveryFulfillmentFulfillmentManager',
                component: DeliveryFulfillmentFulfillmentManager
            },
            {
                path: '/deliveryFulfillments/fulfillments/:id',
                name: 'DeliveryFulfillmentFulfillmentDetail',
                component: DeliveryFulfillmentFulfillmentDetail
            },

            {
                path: '/orderStatuses/orderStatuses',
                name: 'OrderStatusOrderStatusManager',
                component: OrderStatusOrderStatusManager
            },
            {
                path: '/orderStatuses/orderStatuses/:id',
                name: 'OrderStatusOrderStatusDetail',
                component: OrderStatusOrderStatusDetail
            },

            {
                path: '/paymentProcessings/payments',
                name: 'PaymentProcessingPaymentManager',
                component: PaymentProcessingPaymentManager
            },
            {
                path: '/paymentProcessings/payments/:id',
                name: 'PaymentProcessingPaymentDetail',
                component: PaymentProcessingPaymentDetail
            },



    ]
})
