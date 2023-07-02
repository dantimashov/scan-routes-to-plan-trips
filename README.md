# Brief description
The project provides different ways to analyze travel API data to plan your trips. Now it's just a wrapper over the [Tequila travel api](https://tequila.kiwi.com/portal/docs/user_guides) from Kiwi.
But it can be expanded with other external travel data sources. The project uses the Ktor framework for building its own API and the Retrofit for getting external data.  

The primary goal is learning Kotlin language and trying my hand at design of a server-side apllication architecture. However I use it also for real planning my trips and have some bold ideas about future features.

# Running
The entry point is located in Application.kt file, you can use it for local run. Now the project doesn't have some specific requirements, but `tequila_client.properties` should be added to `src/main/resources/` with `host=https://tequila-api.kiwi.com` and your `token`.
  
 
