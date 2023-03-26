import { createApp } from 'vue'
import { createPinia } from 'pinia'
import axios from "axios";
import mitt from 'mitt'
import App from './App.vue'
import router from './router'
import vuexstore from "./vuexstore/index.js";
import {useUserStore} from './stores/user.js'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'


const app = createApp(App)
const pinia = createPinia()

app.use(pinia)
app.use(router)
app.use(ElementPlus)
app.use(vuexstore);

const piniastore=useUserStore(); 
app.config.globalProperties.piniastore=piniastore;
//定义全局属性变量，所有的组件都可以 this.axiosJSON
app.config.globalProperties.axiosJSON = axios.create({
  baseURL: 'http://localhost:8080/Hospital_System_war_exploded/api',
  headers:{"Access-Control-Allow-Origin":"*"}
  
});
//用于文件上传的axios实例对象
app.config.globalProperties.axiosUpload = axios.create({
  baseURL: 'http://localhost:8080/Hospital_System_war_exploded/api',
  headers:{"Access-Control-Allow-Origin":"*","Content-Type":"multipart/form-data"}
  
});

app.config.globalProperties.axiosForm = axios.create({
  baseURL: 'http://localhost:8080/Hospital_System_war_exploded/api',
  headers:{"Content-Type":"application/x-www-form-urlencoded"} 
});


//设置全局的mitt
app.config.globalProperties.emitter = mitt()
//创建根组件对象
const vm=app.mount('#app')

// //引入note的vuex對象
// import notestore from './vuexstore/note.js'
// app.use(notestore);
