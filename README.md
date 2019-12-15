http://wiki.gimslab.com/moniwiki/wiki.php/SpringCloudStream

# spring-cloud-stream-factorial

** 1~n 의 각 수의 팩토리얼 값을 모두 더한 값을 kafka stream을 통해 분산처리 하여 구한다.

### Bindings(topic)
* factorial-seed-out (tp:factorial.seed)
    + --(consume)--> factorial-seed-in --(produce)--> factorial-result-out (tp:factorial.result)
        + --(consume)--> factorial-result-in
    + --(consume)--> factorial-seed-to-split-in --(produce)--> factorial-splitted-result-out(tp:factorial.splitted-result)


