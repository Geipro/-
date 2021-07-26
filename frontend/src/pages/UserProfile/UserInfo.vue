<template>
  <card class="card-user">
    <div class="text-center d-flex justify-content-start">
      <button href="#" class="btn btn-simple"><i class="fa fa-facebook-square"></i></button>
      <button href="#" class="btn btn-simple"><i class="fa fa-twitter"></i></button>
    </div>
    <p class="description text-center"> "Lamborghini Mercy <br>
      Your chick she so thirsty <br>
      I'm in that two seat Lambo"
      "Lamborghini Mercy <br>
      Your chick she so thirsty <br>
      I'm in that two seat Lambo"
      "Lamborghini Mercy <br>
      Your chick she so thirsty <br>
    </p>
  </card>
</template>
<script>
  import Card from 'src/components/Cards/Card.vue'
  export default {
    components: {
      Card
    },
    data () {
      return {

      }
    },
    methods: {
      getClasses (index) {
        var remainder = index % 3
        if (remainder === 0) {
          return 'col-md-3 col-md-offset-1'
        } else if (remainder === 2) {
          return 'col-md-4'
        } else {
          return 'col-md-3'
        }
      }
    }
  }

</script>
<style>

</style>
