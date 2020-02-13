import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
    /*
    Класс Finder обладает одним public и одним private методом
    Задача public-метода вернуть Set из групп в которых состоят члены старше заданного возраста
    Если в группе есть хотя бы один член старше заданного возраста, группа включается в итоговый Set
    private-метод носит чисто вспомогательный характер
    */
public class Finder {
    public Set<String> findGroupsOfOldMembers(List<MembersGroup> groups, int targetAge) {
        return groups.stream() // стрим обьектов MembersGroup
                .filter(membersGroup -> Finder.hasOldMembers(membersGroup,targetAge)) // фильтруем нашим методом hasOldMembers
                .map(MembersGroup::getGroupName) // Достаем имена MembersGroup
                .collect(Collectors.toSet()); // возвращаем Set из этих имен
    }
    private static boolean hasOldMembers(MembersGroup group,int targetAge) { //метод проверяющий есть ли в группе члены старше targetAge
        return group.getMembers().stream() // стрим из списка возвращаемого методом обьекта MembersGroup getMembers (элементы мтрима -  обьекты Member)
                .anyMatch(member -> member.getAge()>targetAge); // если хоть один Member в MembersGroup старше чем targetAge возвращаем true
    }
}
