<template>
  <div>
    <ul>
      <student-item v-for="student in students" :student="student"></student-item>

    </ul>
  </div>
</template>

<script>
  import StudentItem from "./StudentItem"
  import axios from 'axios'
  import {mapMutations, mapState} from 'vuex'

  export default {
    name: "StudentTable",
    components: {StudentItem},
    mounted() {
      axios.get("/student/getStudents").then(res => {
        this.setStudents(res.data)
      })
    },
    computed: {
      ...mapState(['students'])
    },
    methods: {
      ...mapMutations(['setStudents'])
    }
  }
</script>

<style scoped>

</style>
