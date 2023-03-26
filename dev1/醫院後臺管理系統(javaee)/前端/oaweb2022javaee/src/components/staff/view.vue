<template>
<div>
<div class="container" v-if="manager!=null">
  <div class="row">
    <div class="col-4">
      账号
    </div>
    <div class="col-8">
      {{manager.id}}
    </div>
  </div>
  <div class="row">
    <div class="col-4">
      姓名
    </div>
    <div class="col-8">
      {{manager.name}}
    </div>
  </div>
  <div class="row">
    <div class="col-4">
      工作
    </div>
    <div class="col-8">
     <span v-if="manager.work!=null">{{manager.work.name}}</span>
    </div>
  </div>
  <div class="row">
    <div class="col-4">
      性别
    </div>
    <div class="col-8">
      {{manager.sex}}
    </div>
  </div>
  <div class="row">
    <div class="col-4">
      年龄
    </div>
    <div class="col-8">
      {{manager.age}}
    </div>
  </div>
  <div class="row">
    <div class="col-4">
      工资
    </div>
    <div class="col-8">
      {{manager.salary}}
    </div>
  </div>
  <div class="row">
    <div class="col-4">
     入职日期
    </div>
    <div class="col-8">
      {{manager.joinDate}}
    </div>
  </div>

  <div class="row">
    <div class="col-4">
     出生日期
    </div>
    <div class="col-8">
      {{manager.birthday}}
    </div>
  </div>

  <div class="row">
    <div class="col-4">
     地址
    </div>
    <div class="col-8">
      {{manager.address.address}}
    </div>
  </div>

  <div class="row">
    <div class="col-4">
     城市
    </div>
    <div class="col-8">
      {{manager.address.city}}
    </div>
  </div>

  <div class="row">
    <div class="col-4">
     邮编
    </div>
    <div class="col-8">
      {{manager.address.postcode}}
    </div>
  </div>

  <div class="row" v-if="manager.photoFileName!=null">
    <div class="col-4">
      照片
    </div>
    <div class="col-8">
      <img v-bind:src="photoUri" width="300" height="300" />
    </div>
  </div>
  <div class="row">
    <div class="col-4">
     负责区域
    </div>
    <div class="col-8">
      <span v-for="bm in manager.areas" :key="bm.no">{{bm.name}} </span>
    </div>
  </div>
  
  <router-link to="/manager/list" class="btn btn-secondary">返回</router-link>
</div>
<div class="container" v-else >
	<div class="row">
	  没有指定的雇員
	</div>
	<router-link to="/manager/list" class="btn btn-secondary">返回</router-link>
</div>
</div>
</template>

<script>
	export default {
		name:"ManagerView",
		data(){
			return {
				manager:{},
				photoUri:"",
				managerArea:null,
       
			}
		},
		methods:{
			getById(){
				this.axiosJSON.get("/manager/get.do?id="+this.id).then(result=>{
					this.manager=result.data.model;
					if(this.manager!=null){
						this.photoUri="http://localhost:8080/Hospital_System_war_exploded/api/manager/photo.do?id="+this.manager.id;
					}
				});
			}
		},		
		props:{
			id:{				
				required:true
			}
		},
		created(){
			this.$parent.$parent.title="雇員管理-查看雇員";
			this.getById();
			
		}
	}
</script>

<style>
</style>