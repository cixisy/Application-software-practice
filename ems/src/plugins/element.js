import { createApp } from 'vue'
import App from '../App.vue'
import { Button } from 'element-ui'
import { Carousel, CarouselItem } from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
createApp().use(Carousel)
createApp().use(CarouselItem)
createApp(App).use(Button)
