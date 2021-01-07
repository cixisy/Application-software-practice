<template>
    <div style="width:800px;margin-left: 50px">
        <el-table
                :data="tableData"
                style="width: 100%">
            <el-table-column
                    prop="date"
                    label="日期"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="name"
                    label="审批人"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="desc"
                    label="审批描述"
                    width="200">
            </el-table-column>
            <el-table-column
                    prop="state"
                    label="审批状态">
            </el-table-column>
            <el-table-column
                    fixed="right"
                    label="操作"
                    width="100">
                <template #default="scope">
                    <el-button @click="toDetails(scope.row)" type="text" size="small">查看</el-button>
                    <el-button type="text" size="small">撤销</el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>

</template>

<script lang="ts">
    import {defineComponent} from 'vue'

    export default defineComponent({
        name: "LeaveState",
        data() {
            return {
                tableData: [{
                    date: '2016-05-02',
                    name: '王小虎',
                    desc: '啦啦啦啦啊啦啦啦啦啦啦啦啦啦啦',
                    state: '通过'
                }]
            }
        },
        methods: {
            toDetails(index: number) {
                this.$router.push('/leavedetails')
            }
        }
    })
</script>

<style scoped>

</style>
