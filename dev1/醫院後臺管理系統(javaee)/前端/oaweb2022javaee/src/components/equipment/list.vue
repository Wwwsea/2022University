<template>
	<div class="card">
	  <div class="card-body">
	    <table id="table" class="table">
	      <thead>
	      <tr>
	        <th>設備编号</th>
	        <th>設備姓名</th>
			<th class="click" @click="changeType('tel')">設備價格
					  <!-- isReverse 為反轉 className -->
					  <span class="icon" :class="{'inverse': isReverse}" v-if="sortType == 'tel'">
						<i class=" fas fa-angle-up text-success"></i>
					  </span>
			</th>
	      </tr>
	      </thead>
	      <tbody>
	     <tr v-for="cm in sortData" v-bind:key="cm.no" v-on:click="selectClient(cm.no)" v-bind:class="{CRSelectedBG:checkSelected(cm.no)}" >
	       <td>{{cm.no}}</td>
	       <td>{{cm.name}}</td>
	       <td>{{cm.tel}}</td>
	     </tr>
	      </tbody>
	    </table>
		<div class="row">
			<div class="col">
			    个数:{{count}} 页数:{{page}}/{{pageCount}} 
			</div>
			<div class="col">
			      <nav aria-label="設備分页">
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
		name:"ClientList",
		data(){
			return {
				clientList:[],
				clientNo:0,
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
				this.axiosJSON.get("/client/list/page.do",{
									params:{
										rows:this.rows,
										page:this.page
									}
								}).then(result=>{
									this.clientList=result.data.list;
									this.count=result.data.count;
									this.pageCount=result.data.pageCount;
								});
			},
			selectClient(no){ //点击TR事件处理
				this.clientNo=no;
				this.$parent.$parent.clientNo=no; //辅助给父组件的数据属性				
			},
			checkSelected(no){ //检查no是否被选中
				return this.clientNo==no;
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
			this.$parent.$parent.title="設備管理-設備列表";
			this.emitter.on("updateClientList",event=>{
				this.getList();
			})
		},
			computed: {
			    sortData() {
			          var vm = this;
			          var type = vm.sortType;
			          return vm.clientList.sort(function (a, b) {
			            if (vm.isReverse) return b[type] - a[type];
			            else return a[type] - b[type];
			          });
			        }
			  },
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