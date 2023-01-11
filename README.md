Задание:

Необходимо поправить код DAO и сущностей так, чтобы проходили все тесты.

Внимание. Запрещено изменять код проверок (assert-ов).

**Решение**:
- пакет **entity**: оформлены сущности `Area`, `Employer`, `Resume`, `Vacancy`.
- пакет **dao**:
  - написаны запросы JPQL в `EmployerDao`,  `VacancyDao`;
  - добавлен метод `update` в `GenericDao` для того, что бы в `EmployerService` мержить состояние "плохого" `employer` и его вакансий. 
- пакет **service**: в методе `blockIfEmployerUseBadWords` сервиса `EmployerService`  добавлено обновление `employer` для возврата в **managed** состояние.
