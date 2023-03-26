<template>
	<section class="content">
	  <div class="container-fluid">
	    <!-- Small boxes (Stat box) -->
	    <div class="row">
	      <div class="col-lg-4 col-6">
	        <!-- small box -->
	        <div class="small-box bg-info">
	          <div class="inner">
	            <h3>3</h3>
	            <p>藥物个数</p>
	          </div>
	          <div class="icon">
	            <i class="ion ion-bag"></i>
	          </div>
	          <router-link to="/dish" class="small-box-footer">藥物信息<i class="fas fa-arrow-circle-right"></i></router-link>
	        </div>
	      </div>
	      <!-- ./col -->
	      <div class="col-lg-4 col-6">
	        <!-- small box -->
	        <div class="small-box bg-success">
	          <div class="inner">
	            <h3>12</h3>
	            <p>設備个数</p>
	          </div>
	          <div class="icon">
	            <i class="ion ion-stats-bars"></i>
	          </div>
	          <router-link to="/client" class="small-box-footer">設備信息<i class="fas fa-arrow-circle-right"></i></router-link>
	        </div>
	      </div>
	      <!-- ./col -->
	      <div class="col-lg-4 col-6">
	        <!-- small box -->
	        <div class="small-box bg-warning">
	          <div class="inner">
	            <h3>11</h3>
	            <p>職員等級</p>
	          </div>
	          <div class="icon">
	            <i class="ion ion-person-add"></i>
	          </div>
	          <router-link to="/work" class="small-box-footer">職員等級<i class="fas fa-arrow-circle-right"></i></router-link>
	        </div>
	      </div>
	      
	    </div>
	    <!-- /.row -->
	    <!-- Main row -->
	    <div class="row">
	      <!-- Left col -->
	      <section class="col-lg-12 connectedSortable">
	        <!-- Custom tabs (Charts with tabs)-->
	        <div class="card">

	          <div class="card-body text-center">
	            <h2>歡迎您的諫言</h2>
				
				<div id="app">
			
					<div class="notes-section">
					  <div class="columns">
						<div class="centerea-left">
						  <strong>Notes</strong>
						  <div v-for="note in notes" class="notes">
							{{ note }}
						  </div>
						</div>
						<div class="centerea-right">
						  <strong>Timestamp</strong>
						  <div v-for="timestamp in timestamps" class="timestamps">
							{{ timestamp }}
						  </div>
						</div>
					  </div>
							<input
							  placeholder='此處寫入您的寶貴建議~'
							  v-model="input"
							  @keyup.enter="monitorEnterKey"
							  class="inputNote"
							  type="text" />
					</div>
						<div class="note-count">
						  Note count: <strong>{{ noteCount }}</strong>
						</div>
				</div>
				
	          </div><!-- /.card-body -->
	        </div>
	        <!-- /.card -->
	
	        <!-- /.card -->
	      </section>
		  

			<!-- /.Left col -->
	      <!-- right col (We are only adding the ID to make the widgets sortable)-->
	      
	    </div>
	    <!-- /.row (main row) -->
	  </div><!-- /.container-fluid -->
	</section>
	
</template>

<script>
	export default {
		name:"HomeMain",
		data(){
			return{
				notes: [],
				timestamps: [],
				input: '',
				
			}
		},
		computed: {
		  noteCount() {
		    return this.$store.getters.getNoteCount;
		  }, 
		  notes() {
		    return this.$store.getters.getNotes;
		  },
		  timestamps() {
		    return this.$store.getters.getTimestamps;
		  },
		},
		methods: {
		  monitorEnterKey () {
		    this.$store.dispatch('addNote', this.input);
		    this.$store.dispatch('addTimeStamp', new Date().toLocaleString());
		    this.input = ''; // set input field back to blank
		  }
		},
	}
</script>

<style>

.card{
	/* height: 300px; */
}
		#app {
		  /* height: auto;
		  margin: 0 auto;
		  display: flex; */
		  /* flex-direction: column; */
		  align-items: center;
		 -webkit-align-items: center;
		  justify-content: center;
		  -webkit-justify-content: center;
		}
		
		.notes-section {
		  width: 800px;
		}
		
		.columns {
		  width: 500px;
		}
		
		.notes, .timestamps {
		  padding: 5px 0px;
		}
		
		.note-count {
		  margin-top: 48px;
		  position: relative;
		  top:150px;
		  margin-top: 20px;
		}
		.centerea-left{
			/* float: left;
			left: 200px; */
			position: absolute;
			margin-top: 10px;
			left: 100px;
			width:450px ;
			margin-right: 5px;
		}
		.centerea-right{
			/* float: right; */
			position: absolute;
			margin-top: 10px;
			right: 250px;
			margin-left: 10px;
		}
		
		.inputNote{
			position:relative ;
			margin-left: 80px;
			top: 220px;
			margin-top: 10px;
		}

</style>