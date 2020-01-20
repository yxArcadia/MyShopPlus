
import Vue from 'vue';
import Router from 'vue-router';
import Login from '../views/Login';
import NotFound from '../views/NotFound'
import Reg from '../views/Register';
import Index from "../views/Index";
import Search from '../views/Search';
import Details from '../views/Details'
import ShoppingCart from '../views/ShoppingCart'
import Pay from "../views/Pay";
import Order from "../views/Order";
import Address from "../views/Address";
import ChangePassword from "../views/ChangePassword";
Vue.use(Router);

export default new Router({
  routes:[
    {
      name:'Login',
      path:'/login',
      component:Login
    },
    {
      path:"*",
      component:NotFound
    },{
      name:"Reg",
      path:"/register",
      component:Reg
    },
    {
      name:"Index",
      path:"/index",
      component:Index,
    },
    {
      name:"Search",
      path:"/search",
      component:Search,
    },
    {
      name:"Details",
      path:"/details",
      component:Details,
    },
    {
      name:"ShoppingCart",
      path:"/shoppingcart",
      component:ShoppingCart,
    },
    {
      name:"Pay",
      path:"/pay",
      component:Pay,
    },
    {
      name:"Order",
      path:"/order",
      component:Order,
    },
    {
      name:"Address",
      path:"/address",
      component:Address,
    },
    {
      name:"ChangePassword",
      path:"/changepassword",
      component:ChangePassword,
    }
  ],
});
