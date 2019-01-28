<template>
    <headTop></headTop>
</template>

<script>
	import {baseImgPath} from '@/config/env'
	import header from '@/components/headerTop'

    export default {
    	data(){
    		return {
				baseImgPath				
    		}
		},
		components:{
  			headTop : header
  		}
    }
</script>
