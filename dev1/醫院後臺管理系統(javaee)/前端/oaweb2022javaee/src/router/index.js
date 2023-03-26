import { createRouter, createWebHistory } from 'vue-router'
//引入Pinia Store
import {useUserStore} from './../stores/user.js'
//引入Vuex Store
import vuexstore from "./../vuexstore/index.js";

import HomeMain from "./../components/home/homemain.vue";
import UserLogin from "./../components/home/login.vue";

import MedicalMain from "./../components/medical/main.vue";
import MedicalAdd from "./../components/medical/add.vue";
import MedicalModify from "./../components/medical/modify.vue";
import MedicalList from "./../components/medical/list.vue";
import MedicalView from "./../components/medical/view.vue";

import EquipmentMain from "./../components/equipment/main.vue";
import EquipmentAdd from "./../components/equipment/add.vue";
import EquipmentModify from "./../components/equipment/modify.vue";
import EquipmentList from "./../components/equipment/list.vue";
import EquipmentView from "./../components/equipment/view.vue";

import StatusMain from "./../components/status/main.vue";
import StatusList from "./../components/status/list.vue";
import StatusAdd from "./../components/status/add.vue";
import StatusModify from "./../components/status/modify.vue";
import StatusView from "./../components/status/view.vue";

import OfficeMain from "./../components/office/main.vue";
import OfficeAdd from "./../components/office/add.vue";
import OfficeModify from "./../components/office/modify.vue";
import OfficeList from "./../components/office/list.vue";
import OfficeView from "./../components/office/view.vue";

import StaffMain from "./../components/staff/main.vue";
import StaffList from "./../components/staff/list.vue";
import StaffAdd from "./../components/staff/add.vue";
import StaffModify from "./../components/staff/modify.vue";
import StaffView from "./../components/staff/view.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeMain,
	  beforeEnter(to,from){ //路由级别的路由守卫方法，返回false, 阻止路由的跳转
		  
	  }
    },
	{
		path:"/login",
		name:"login",
		component:UserLogin
	},

	{
		path: '/dish',
		name: 'dishmain',
		component: MedicalMain,
		children:[
			{
				path:"list",
				name:"dishlist",
				component:MedicalList			
			},
			{
				name:"dishadd",
				path:"add",
				component:MedicalAdd,
			  meta:{requirelogin:true, requireRole:"admin"},
			  beforeEnter(to,from){
				  console.log(`增加藥物:需要登录${to.meta.requirelogin},角色:${to.meta.requireRole}`)				
			  }			
			},
			{
				name:"dishmodify",
				path:"modify/:no",
				component:MedicalModify,
				props:true
			},
			{
				name:"dishview",
				path:"view/:no",
				component:MedicalView,
				props:true
			},
		  {
			  path:"",redirect:"/dish/list"
		  }
		]
	  },


	  {
		path: '/client',
		name: 'clientmain',
		component: EquipmentMain,
		children:[
			{
				path:"list",
				name:"clientlist",
				component:EquipmentList			
			},
			{
				name:"clientadd",
				path:"add",
				component:EquipmentAdd,
			  meta:{requirelogin:true, requireRole:"admin"},
			  beforeEnter(to,from){
				  console.log(`增加設備:需要登录${to.meta.requirelogin},角色:${to.meta.requireRole}`)				
			  }			
			},
			{
				name:"clientmodify",
				path:"modify/:no",
				component:EquipmentModify,
				props:true
			},
			{
				name:"clientview",
				path:"view/:no",
				component:EquipmentView,
				props:true
			},
		  {
			  path:"",redirect:"/client/list"
		  }
		]
	  },


	{
	  path: '/work',
	  name: 'workmain',
	  component: StatusMain,
	  children:[
	  	{
	  		path:"list",
	  		name:"worklist",
	  		component:StatusList			
	  	},
	  	{
	  		name:"workadd",
	  		path:"add",
	  		component:StatusAdd,
			meta:{requirelogin:true, requireRole:"admin"},
			beforeEnter(to,from){
				console.log(`增加該職員等級:需要登录${to.meta.requirelogin},角色:${to.meta.requireRole}`)				
			}			
	  	},
	  	{
	  		name:"workmodify",
	  		path:"modify/:no",
	  		component:StatusModify,
	  		props:true
	  	},
	  	{
	  		name:"workview",
	  		path:"view/:no",
	  		component:StatusView,
	  		props:true
	  	},
		{
			path:"",redirect:"/work/list"
		}
	  ]
	},
	{
	  path: '/area',
	  name: 'areamain',
	  component: OfficeMain,
	  children:[
	  	{
	  		path:"list",
	  		name:"arealist",
	  		component:OfficeList			
	  	},
	  	{
	  		name:"areaadd",
	  		path:"add",
	  		component:OfficeAdd
	  	},
	  	{
	  		name:"areamodify",
	  		path:"modify/:no",
	  		component:OfficeModify,
	  		props:true
	  	},
	  	{
	  		name:"areaview",
	  		path:"view/:no",
	  		component:OfficeView,
	  		props:true
	  	},
	  	{
	  		path:"",redirect:"/area/list"
	  	}
	  ]
	},
	{
	  path: '/manager',
	  name: 'managermain',
	  component: StaffMain,
	  children:[
	  	{
	  		name:"managerlist",
	  		path:"list",
	  		component:StaffList
	  	},
	  	{
	  		name:"manageradd",
	  		path:"add",
	  		component:StaffAdd
	  	},
	  	{
	  		name:"managermodify",
	  		path:"modify/:id",
	  		component:StaffModify,
	  		props:true,
			beforeEnter(to,from){
				console.log("路由级别的守卫方法",from.path);
				
			}
	  	},
	  	{
	  		name:"managerview",
	  		path:"view/:id",
	  		component:StaffView,
	  		props:true
	  	},
	  	{ path: "", redirect: "/manager/list" }
	  
	  ]
	}
    
  ]
})
//全局路由守卫，检查是否登录
//使用Pinia全局store
/*
router.beforeEach((to,from)=>{
	console.log("beforeEach守卫");
	const piniastore=useUserStore(); 	
	if(to.path=="/login"){
		return true;
	}	
	else if(piniastore.user!=null){
		return true;
	}
	else{
		return {name:"login"};
	}
});
*/

//使用Vuex全局store

router.beforeEach((to,from)=>{
	if(to.path=="/login"){
		return true;
	}	
	else if(vuexstore.state.user!=null){
		return true;
	}
	else{
		return {name:"login"};
	}
});




router.beforeResolve( to=>{
	console.log("beforeResolve守卫");
	console.log(to.path, to.name);
});

export default router
