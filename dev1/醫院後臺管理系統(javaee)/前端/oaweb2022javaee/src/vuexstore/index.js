import { createStore } from 'vuex'


export default createStore({
  state(){
	  
	  return {
		 user:null,
		 dialogVisible:false,
		 dialogTitle:"",
		 notes:[],
		timestamps:[],
	  }	  
  },
  mutations: {
	  setUser(state,user){
		  state.user=user;
	  },
	  setDialogVisible(state,value){
		  state.dialogVisible=value;
	  },
	  setDialogTitle(state,title){
		  state.dialogTitle=title;
	  },
	  ADD_NOTE (state, payload) {
	    let newNote = payload;
	    state.notes.push(newNote);
	  },
	  ADD_TIMESAMP (state, payload) {
	    let newTimeStamp = payload;
	    state.timestamps.push(newTimeStamp);
	  },
  },
  actions: {
	  loginUser(context,user){
		  context.commit("setUser",user);
	  },
	  logoutUser(context){
		  context.commit("setUser",null);
	  },
	  showDialog(context){
		  context.commit("setDialogVisible",true);
	  },
	  hideDialog(context){
		  context.commit("setDialogVisible",false);
	  },
	  settingDialogTitle(context,title){
		  context.commit("setDialogTitle",title);
	  },
	  addNote (context, payload) {
	    context.commit('ADD_NOTE', payload);
	  },
	  addTimeStamp (context, payload) {
	    context.commit('ADD_TIMESAMP', payload);
	  }
	  
  },
  getters:{
	  loginusername(state){
		  return state.user.name;
	  },
	  getNotes: state => state.notes,
	  getTimestamps: state => state.timestamps,
	  getNoteCount: state => state.notes.length
  }
})
