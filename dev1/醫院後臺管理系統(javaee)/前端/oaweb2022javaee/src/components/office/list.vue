<template>
	<div class="card">
	   <div class="card-body">
		   部門名稱: &nbsp;<input type="text" placeholder="請在這裏輸入需要查詢的部門" style="width: 300px;" v-model="deptName" v-on:keyup.enter="Enter">
		   &nbsp;&nbsp;
	    <table id="example2" class="table table-bordered" @sort-change="sortChange">
	      <thead>
	      <tr>
	        <th prop="block" sortChange="custom">部門编号</th>
	        <th>部門名称</th>
	      </tr>
	      </thead>
	      <tbody>
			  
		  <tr v-if ="[null,'全部','all'].includes(this.deptName)" v-for="bm in areaList" v-bind:key="bm.no" v-on:click="selectArea(bm.no)" v-bind:class="{CRSelectedBG:checkSelected(bm.no)}" >
	        <td>{{bm.no}}</td>
	        <td>{{bm.name}}</td>
	      </tr>
		  <tr v-else v-for="bm in searchData" :key="bm.no" v-on:click="selectArea(bm.no)" v-bind:class="{CRSelectedBG:checkSelected(bm.no)}" >
			  <td>{{bm.no}}</td>
			  <td>{{bm.name}}</td>
		  </tr>
	      </tbody>
	    </table>
		<div class="row">
			<div class="col">
			    个数:{{count}} 页数:{{page}}/{{pageCount}} 
			</div>
			<div class="col">
			      <nav aria-label="部門分页">
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
		name:"AreaList",
		data(){
			return {
				areaList:[],
				areaNo:0,
				page:1,
				count:0,
				pageCount:0,
				rows:5,
				deptName:null
			};
		},
		methods:{
			getList(){
				this.axiosJSON.get("/area/list/all/page.do",{
									params:{
										rows:this.rows,
										page:this.page
									}
								}).then(result=>{
									this.areaList=result.data.list;
									this.count=result.data.count;
									this.pageCount=result.data.pageCount;
								});
			},
			selectArea(no){ //点击TR事件处理
				this.areaNo=no;	
				this.$parent.$parent.areaNo=no; //辅助给父组件的数据属性
			},
			checkSelected(no){ //检查no是否被选中
				return this.areaNo==no;
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
			this.emitter.on("updateAreaList",event=>{
				this.getList();
			})
		},
		computed:{//響應式數據
		//糢糊查找
			searchData(){
				return this.areaList.filter(bm=>bm.name.indexOf(this.deptName)!=-1)
			}
		}
	}
</script>

<style>
</style>