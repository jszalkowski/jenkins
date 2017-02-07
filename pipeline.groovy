#!groovy
// This is the initial seed job for venicegeo which creates all of ther
// other pipeline jobs. Each repo must contain a JenkinsFile
// that denotes the steps to take when building.

def gitprefix = 'https://github.com/venicegeo/'

def bfprojects = ['bf-ui']

for(i in bfprojects) {
  pipelineJob("VeniceGeo/beachfront/${i}-pipeline") {
    description("Beachfront automated pipeline")
    triggers {
//      gitHubPushTrigger()
    }
    definition {
      cpsScm {
        scm {
          git {
            remote {
              url("${gitprefix}${i}")
              branch("*/master")
            }
          }
       }
     }
   }
  }
}
