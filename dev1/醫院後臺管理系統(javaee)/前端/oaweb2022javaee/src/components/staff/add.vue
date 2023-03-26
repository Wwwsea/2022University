<template>
	<div>
		<form @submit.prevent="add">
			<div class="mb-3 row">
			    <label for="inputPassword" class="col-sm-2 col-form-label">账号</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" v-model="manager.id" required="required">
			    </div>
			</div>
			<div class="mb-3 row">
			    <label for="inputPassword" class="col-sm-2 col-form-label">密码</label>
			    <div class="col-sm-10">
			      <input type="password" class="form-control" v-model="manager.password" required="required">
			    </div>
			</div>
			<div class="mb-3 row">
			    <label for="inputPassword" class="col-sm-2 col-form-label">姓名</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" v-model="manager.name" required="required">
			    </div>
			</div>
			<div class="mb-3 row">
			    <label  class="col-sm-2 col-form-label">工作</label>
			    <div class="col-sm-10">
					<select class="form-control" v-model="manager.work.no"  placeholder="选择工作" >
						<option v-for="dm in workList" v-bind:key="dm.no" v-bind:value="dm.no">{{dm.name}}</option>
					</select>
			    </div>
			</div>
			<div class="mb-3 row">
			    <label for="inputPassword" class="col-sm-2 col-form-label">性别</label>
			    <div class="col-sm-10">
			      <div class="row">
			        <div class="col">
			          <input type="radio" name="sex" v-model="manager.sex" value="男" checked="checked">男
			        </div>
			        <div class="col">
			          <input type="radio" name="sex" v-model="manager.sex" value="女">女
			        </div>
			      </div>
			    </div>
			</div>
			<div class="mb-3 row">
			    <label for="inputPassword" class="col-sm-2 col-form-label">年龄</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" v-model="manager.age" required="required" >
			    </div>
			</div>
			<div class="mb-3 row">
			    <label  class="col-sm-2 col-form-label">工资</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control"
				   pattern="^\d{3,}$" title="(至少三位有效數字)"
				   v-model="manager.salary" >
			    </div>
			</div>
			<div class="mb-3 row">
			    <label  class="col-sm-2 col-form-label">生日</label>
			    <div class="col-sm-10">
			      <input type="date" class="form-control" v-model="manager.birthday" >
			    </div>
			</div>
			<div class="mb-3 row">
			    <label  class="col-sm-2 col-form-label">入职</label>
				    <div class="col-sm-10">
			      <input type="date" class="form-control" v-model="manager.joinDate" >
			    </div>
			</div>
			<div class="mb-3 row">
			    <label  class="col-sm-2 col-form-label">地址</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" v-model="manager.address.address" >
			    </div>
			</div>
			<div class="mb-3 row">
			    <label  class="col-sm-2 col-form-label">城市</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" 
					  pattern="^[\u4E00-\u9FA5]{2,13}$" title="請輸入正確漢字"
					  v-model="manager.address.city" >
			    </div>
			</div>
			<div class="mb-3 row">
			    <label  class="col-sm-2 col-form-label">邮编</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control"
					   pattern="[1-9]d{5}(?!d)" title="六位郵政編碼"
					   v-model="manager.address.postcode" >
			    </div>
			</div>
			<div class="mb-3 row">
			    <label  class="col-sm-2 col-form-label">照片</label>
			    <div class="col-sm-10">
			      <input type="file" class="form-control" @change="getUpload" >
			    </div>
			</div>
			<div class="mb-3 row">
				    <label  class="col-sm-2 col-form-label">負責部門</label>
				    <div class="col-sm-10">
					<span v-for="bm in areaList" v-bind:key="bm.no">
				       <input type="checkbox" v-model="areas"  v-bind:value="bm.no" />{{bm.name}}
					</span>
					</div>
			</div>
			
			<button type="submit" class="btn btn-secondary">提交</button> | 
			<router-link to="/employee/list" class="btn btn-secondary">返回</router-link>
		</form>
	</div>
</template>

<script>
	export default {
		name:"ManagerAdd",
		data(){
			return {
				manager:{
					id:"",
					password:"",
					name:"",
					sex:"男",
					age:0,
					birthday:null,
					joinDate:null,
					work:{
						no:0
					},
					address:{
						address:"",
						city:"",
						postcode:""
					}
				},
				manPhoto:null,
				areas:[],
				workList:null,
				areaList:null
				
			}
		},
		methods:{
			getWorkList(){
				this.axiosJSON.get("/work/list.do").then(result=>{
					this.workList=result.data.list;									
				});
			},
			getAreaList(){
				this.axiosJSON.get("/area/list/all.do").then(result=>{
					this.areaList=result.data.list;									
				});
			},
			add(){
				
				let data = new FormData(); //创建form对象
				data.append("id",this.manager.id);
				data.append("password",this.manager.password);
				data.append("department.no",this.manager.work.no);
				data.append("name",this.manager.name);
				data.append("sex",this.manager.sex);
				data.append("age",this.manager.age);
				data.append("salary",this.manager.salary);
				data.append("birthday",this.manager.birthday);
				data.append("joinDate",this.manager.joinDate);
				
				data.append("manareas",this.areas);
				
				data.append("address.address",this.manager.address.address);
				data.append("address.city",this.manager.address.city);
				data.append("address.postcode",this.manager.address.postcode);
				
				
				data.append('photo',this.manPhoto);//通过append向form对象添加数据
				this.axiosUpload.post("/manager/add.do",data).then(result=>{
					alert(result.data.message);
					this.$router.push("/manager/list");
				});
			},
			getUpload(event){
				this.manPhoto=event.target.files[0];
				
			}
		},
		created(){
			this.$parent.$parent.title="雇員管理-增加雇員";
			this.getAreaList();
			this.getWorkList();
		},
		
	}
</script>

<style>
</style>