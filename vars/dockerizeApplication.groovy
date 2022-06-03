def call(Map config = [:]) {
    appImage = docker.build "${config.serviceName}"
    docker.withRegistry("${config.DOCKER_REGISTRY_URL}", "${config.REGISTRY_CREDENTIAL}") {
        appImage.push("latest")
        appImage.push("${env.imageTag}")
    }
}