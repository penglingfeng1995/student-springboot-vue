<template>
    <div>主页
      <student-table></student-table>
    </div>
</template>

<script>
    import StudentTable from "../components/StudentTable"
    export default {
        name: "Main",
      components: {StudentTable}
    }
</script>

<style scoped>

</style>
