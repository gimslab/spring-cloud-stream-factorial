# spring-cloud-stream-factorial

** 1~100 의 각 수의 팩토리얼 값을 모두 더한 값을 kafka stream을 통해 분산처리 하여 구한다.

Main.produceSeed() : produce key message (1~15) --> binding:factorial-seed-out(topic:factorial.seed)

binding:factorial-seed-in(topic:factorial.seed) --> SeedHandler --> binding:factorial-result-out(topic:factorial.result)

binding:factorial-result-in(topic:factorial.result) --> ResultHandler
