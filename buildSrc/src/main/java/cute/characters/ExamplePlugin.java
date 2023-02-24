package cute.characters;

import java.util.Set;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskDependency;
import org.gradle.api.tasks.TaskProvider;
import org.gradle.api.Task;

public final class ExamplePlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        TaskProvider<?> publishTask = createPublishTask(project);
    }


    private static TaskProvider<?> createPublishTask(Project project) {
        return project.getTasks().register("publishNewCharacter", publish -> {
            publish.onlyIf(_ignored -> {
                Task extractConjureTask = project.getRootProject().getTasks().getByPath("extractConjure");
                TaskDependency taskDep = extractConjureTask.getTaskDependencies();
                Set<Task> neighbors = (Set<Task>) taskDep.getDependencies(extractConjureTask);
                return extractConjureTask.getState().getFailure() != null;
            });
        });
    }
}
