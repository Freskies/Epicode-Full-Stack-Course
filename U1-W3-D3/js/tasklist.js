"use strict";

const tasklistWebapp = {
	htmlElements: {
		taskForm: document.querySelector(".task-form"),
		taskInput: document.querySelector(".task-input"),
		taskList: document.querySelector(".task-list"),
		buttonDelete: document.querySelector(".section-tasks > .btn"),
	},

	addTask: function (task) {
		if (task) {
			const li = this.htmlElements.taskList.appendChild(
				document.createElement("li"),
			);
			const span = li.appendChild(document.createElement("span"));
			span.textContent = task;
			const button = li.appendChild(
				this.htmlElements.buttonDelete.cloneNode(true),
			);
			button.addEventListener("click", () => this.deleteTaskListener(li));
			li.addEventListener("click", this.clickTaskListener);
		}
	},

	clickTaskListener: function () {
		this.classList.toggle("completed-task");
	},

	deleteTaskListener: function (li) {
		li.remove();
	},

	formListener: function (self, e) {
		e.preventDefault();
		self.addTask(self.htmlElements.taskInput.value);
		self.htmlElements.taskInput.value = "";
	},

	start: function () {
		this.htmlElements.taskForm.addEventListener("submit", e =>
			this.formListener(this, e),
		);
	},
};

tasklistWebapp.start();
