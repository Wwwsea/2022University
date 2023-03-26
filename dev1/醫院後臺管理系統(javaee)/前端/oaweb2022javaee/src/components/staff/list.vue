<template>
	<div class="card">
	   <div class="card-body">
			<table class="table table-bordered">
			  <thead>
			    <tr>
			      <th scope="col">账号</th>
			      <th scope="col">姓名</th>
				  <th scope="col">工作</th>
			      <th scope="col">性别</th>
			      <th scope="col">年龄</th>
				  <th scope="col">工资</th>
				  <th scope="col">入职日期</th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr v-for="em in managerList" v-bind:key="em.id" v-on:click="selectManager(em.id)" v-bind:class="{CRSelectedBG:checkManagerSelected(em.id)}" >
			      <th scope="row">{{em.id}}</th>
			      <td>{{em.name}}</td>
				  <td>{{em.work.name}}</td>
			      <td>{{em.sex}}</td>
				  <td>{{em.age}}</td>
				  <td>{{em.salary}}</td>
				  <td>{{em.joinDate}}</td>
			    </tr>
			  </tbody>
			</table>
			<div class="row">
				<div class="col">
				    个数:{{count}} 页数:{{page}}/{{pageCount}} 
				</div>
				<div class="col">
				      <nav aria-label="雇員分页">
				        <ul class="pagination">
				          <li class="page-item"><a class="page-link" href="#" @click="firstPage()">首页</a></li>
				          <li class="page-item"><a class="page-link" href="#" @click="previousPage()">上页</a></li>
				          <li class="page-item"><a class="page-link" href="#" @click="nextPage()">下页</a></li>
				          <li class="page-item"><a class="page-link" href="#" @click="lastPage()">末页</a></li>
				        </ul>
				      </nav>
				</div>
			</div>
	  </div>
	</div>
</template>
<script>
	export default {
		name:"ManagerList",
		data(){
			return {
				managerList:null,
				page:1,
				count:0,
				pageCount:0,
				rows:6,
				managerId:null
			}
		},
		methods:{
			getList(){
				this.axiosJSON.get("/manager/list.do",{
									params:{
										rows:this.rows,
										page:this.page
									}
								}).then(result=>{
									this.managerList=result.data.list;
									this.count=result.data.count;
									this.pageCount=result.data.pageCount;
								});
			},
			selectManager(managerId){
				this.managerId=managerId;
				this.$parent.$parent.managerId=managerId;
				
			},
			checkManagerSelected(managerId){
				if(this.managerId==managerId){
					return true;
				}
				else{
					return false;
				}
			},
			nextPage(){
				if(this.page<this.pageCount){
					this.page++;
					this.getList();
				}
			},
			previousPage(){
				if(this.page>1){
					this.page--;					
					this.getList()
				}
			},
			firstPage(){
				this.page=1;
				this.getList()
			},
			lastPage(){
				this.page=this.pageCount;
				this.getList();
			}
		},
		created(){
			this.getList();
			this.$parent.$parent.title="雇員管理-雇員列表";
			this.emitter.on("updateManagerList",event=>{
				this.getList();
				
			});
		}
	}
</script>

<style>
</style>
