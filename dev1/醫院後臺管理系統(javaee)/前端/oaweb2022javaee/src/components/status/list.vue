<template>
	<div class="card">
	  <div class="card-body">
	    <table id="example2" class="table table-bordered">
	      <thead>
	      <tr>
	        <th>等級编号</th>
	        <th>等級编码</th>
	        <th>等級名称</th>	        
	      </tr>
	      </thead>
	      <tbody>
	     <tr v-for="dm in workList" v-bind:key="dm.no" v-on:click="selectWork(dm.no)" v-bind:class="{CRSelectedBG:checkSelected(dm.no)}" >
	       <td>{{dm.no}}</td>
	       <td>{{dm.code}}</td>
	       <td>{{dm.name}}</td>
	     </tr>
	      </tbody>
	    </table>
		<div class="row">
			<div class="col">
			    个数:{{count}} 页数:{{page}}/{{pageCount}} 
			</div>
			<div class="col">
			      <nav aria-label="等級分页">
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
	  <!-- /.card-body -->
	</div>
	<!-- /.card -->	
</template>
<script>
	
	export default {
		name:"WorkList",
		data(){
			return {
				workList:[],
				workNo:0,
				page:1,
				count:0,
				pageCount:0,
				rows:5
			};
		},
		methods:{
			getList(){
				this.axiosJSON.get("/work/list/page.do",{
									params:{
										rows:this.rows,
										page:this.page
									}
								}).then(result=>{
									this.workList=result.data.list;
									this.count=result.data.count;
									this.pageCount=result.data.pageCount;
								});
			},
			selectWork(no){ //点击TR事件处理
				this.workNo=no;
				this.$parent.$parent.workNo=no; //辅助给父组件的数据属性				
			},
			checkSelected(no){ //检查no是否被选中
				return this.workNo==no;
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
			this.$parent.$parent.title="等級管理-等級列表";
			this.emitter.on("updateWorkList",event=>{
				this.getList();
			})
		}	
	}
</script>

<style>
</style>