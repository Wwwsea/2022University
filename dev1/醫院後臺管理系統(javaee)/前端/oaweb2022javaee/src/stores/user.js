import { defineStore } from 'pinia'

export const useUserStore = defineStore('user', {
  state(){
	return {
		user:null,
		dialogVisible:false,
		dialogTitle:"" ,
	}  
  },
  getters: {
    loginUserName(state){
		if(state.user){
			return state.user.name;
		}
		else {
			return null
		}
		
	}
  },
  actions: {
    loginUser(user){
		this.user=user;
	},
	logoutUser(){
		this.user=null;
	}
	
  }
})