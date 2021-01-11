<template>
	<div style="background-color: white;padding-top: 10px;width:1000px;padding-bottom: 10px">

		<el-col :span="2">
			<el-button type="primary" icon="el-icon-back" @click="goBack"></el-button>
		</el-col>
		<el-form :model="ruleForm"  ref="ruleForm" label-width="100px" class="demo-ruleForm" style="margin-left: 200px;margin-top: 20px"
		 disabled>
			<el-form-item label="申请时间">
				<el-col :span="11">
					<el-form-item>
						<el-date-picker type="date" placeholder="选择日期" v-model="ruleForm.apply_time" style="width: 100%;"></el-date-picker>
					</el-form-item>
				</el-col>
			</el-form-item>
			<el-form-item label="员工编号" style="width: 330px;">
				<el-input v-model="ruleForm.epnum" placeholder="请输入员工编号"></el-input>
			</el-form-item>
			<el-form-item label="请假类型" style="width: 330px;">
				<el-select v-model="ruleForm.l_type" placeholder="请选择请假类型">
					<el-option label="事假" value="01"></el-option>
					<el-option label="病假" value="02"></el-option>
					<el-option label="出差" value="03"></el-option>
					<el-option label="带薪休假" value="04"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="开始时间" required>
				<el-col :span="11">
					<el-form-item>
						<el-date-picker type="date" placeholder="选择日期" v-model="ruleForm.l_start" style="width: 100%;"></el-date-picker>
					</el-form-item>
				</el-col>
			</el-form-item>
			<el-form-item label="结束时间" required>
				<el-col :span="11">
					<el-form-item>
						<el-date-picker type="date" placeholder="选择日期" v-model="ruleForm.l_end" style="width: 100%;"></el-date-picker>
					</el-form-item>
				</el-col>
			</el-form-item>

			<el-form-item label="请假原因">
				<el-col :span="11">
					<el-input type="textarea" v-model="ruleForm.l_descrip" placeholder="请说明请假原因" style="width: 400px;" :rows="3"></el-input>
				</el-col>
			</el-form-item>
			<el-form-item label="审批描述">
				<el-col :span="11">
					<el-input type="textarea" v-model="ruleForm.leave_comfirm_descrip" placeholder="" style="width: 400px;"
					 :rows="3"></el-input>
				</el-col>
			</el-form-item>
		</el-form>
	</div>
</template>

<script lang="js">
	/* eslint-disable */
	import {
		defineComponent
	} from 'vue'

	export default defineComponent({
		name: "LeaveDetails",

		data() {
			return {
				ruleForm:{
					apply_time:'',
					epnum:'',
					l_type:'',
					l_start:'',
					l_end:'',
					l_descrip:'',
					leave_comfirm_descrip:''
				}
			};
		},
		beforeRouteEnter: (to, from, next) => {
			next(vm => {
				vm.getParams();
			});
		},
		methods: {
			getParams() {
				this.ruleForm.apply_time = this.$route.query.apply_time;
				this.ruleForm.epnum = this.$route.query.epnum;
				this.ruleForm.l_type = this.$route.query.l_type;
				this.ruleForm.l_start = this.$route.query.l_start;
				this.ruleForm.l_end = this.$route.query.l_end;
				this.ruleForm.l_descrip = this.$route.query.l_descrip;
				this.ruleForm.leave_comfirm_descrip = this.$route.query.leave_comfirm_descrip;
				if(this.ruleForm.l_type == '1'){
					this.ruleForm.l_type = "事假"
				} else if(this.ruleForm.l_type == '2'){
					this.ruleForm.l_type = "病假"
				} else if(this.ruleForm.l_type == '3'){
					this.ruleForm.l_type = "出差"
				} else if(this.ruleForm.l_type == '4'){
					this.ruleForm.l_type = "带薪休假"
				}
			},
			goBack() {
				this.$router.go(-1);
			},
		}
	})
</script>

<style scoped>

</style>
