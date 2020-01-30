<template>
  <li>学号:{{student.studentId}}--姓名:{{student.studentName}}--年龄:{{student.studentAge}}</li>
</template>

<script>
    export default {
        name: "StudentItem",
      props:["student"]
    }
</script>

<style scoped>

</style>
