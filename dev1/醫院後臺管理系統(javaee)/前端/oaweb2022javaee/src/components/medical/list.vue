<template>
	<div class="card">
	  <div class="card-body">
	    <table id="example2" class="table table-bordered">
	      <thead>
	      <tr>
	        <th>藥物编号</th>
	        <th>藥物名称</th>
				<th class="click" @click="changeType('price')">藥物价格
						  <!-- isReverse 為反轉 className -->
						  <span class="icon" :class="{'inverse': isReverse}" v-if="sortType == 'price'">
							<i class=" fas fa-angle-up text-success"></i>
						  </span>
				</th>
	      </tr>
	      </thead>
	      <tbody>
	     <tr v-for="hm in sortData" v-bind:key="hm.no" v-on:click="selectDish(hm.no)" v-bind:class="{CRSelectedBG:checkSelected(hm.no)}" >
	       <td>{{hm.no}}</td>
	       <td>{{hm.name}}</td>
	       <td>{{hm.price}}</td>
	     </tr>
	      </tbody>
	    </table>
		<div class="row">
			<div class="col">
			    个数:{{count}} 页数:{{page}}/{{pageCount}} 
			</div>
			<div class="col">
			      <nav aria-label="藥物分页">
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
		name:"DishList",
		data(){
			return {
				dishList:[],
				dishNo:0,
				page:1,
				count:0,
				pageCount:0,
				rows:5,
				sortType: "price",
				isReverse: false
			};
		},
		methods:{
			getList(){
				this.axiosJSON.get("/dish/list/page.do",{
									params:{
										rows:this.rows,
										page:this.page
									}
								}).then(result=>{
									this.dishList=result.data.list;
									this.count=result.data.count;
									this.pageCount=result.data.pageCount;
								});
			},
			selectDish(no){ //点击TR事件处理
				this.dishNo=no;
				this.$parent.$parent.dishNo=no; //辅助给父组件的数据属性				
			},
			checkSelected(no){ //检查no是否被选中
				return this.dishNo==no;
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
			},
			
			changeType: function (type) {
			      var vm = this;
			      if (vm.sortType == type) {
			        vm.isReverse = !vm.isReverse;
			      } else {
			        vm.isReverse = false;
			      }
			      vm.sortType = type;
			    }
		},
		created(){
			this.getList();
			this.$parent.$parent.title="藥物管理-藥物列表";
			this.emitter.on("updateDishList",event=>{
				this.getList();
			})
		},
		computed: {
		    sortData() {
		          var vm = this;
		          var type = vm.sortType;
		          return vm.dishList.sort(function (a, b) {
		            if (vm.isReverse) return b[type] - a[type];
		            else return a[type] - b[type];
		          });
		        }
		  }
	}
</script>

<style>
	.table th.click {
	   cursor: pointer;
	 }
	 
	 .table th.click {
	   cursor: pointer;
	 }
	 
	 .icon {
	   display: inline-block;
	 }
	 .icon.inverse {
	   transform: rotate(180deg)
	 }
</style>